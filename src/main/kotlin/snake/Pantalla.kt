import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent


import javax.swing.JPanel
import javax.swing.Timer


class Pantalla(width: Int,
    height: Int,
    mapa: Int,
    private val randPos: Int,
    private val delay: Int,
    private val victoria: Int) : JPanel(), ActionListener {

    //TAMAÑO DE LA PANTALLA
    private val boardWidth = width
    private val boardHeight = height

    //TAMAÑO DE LA IMAGEN DENTRO DE LA PANTALLA
    private val dotSize = 10

    //LISTA DE LAS POSICIONES D LA SERPIENTE
    private val x = IntArray(mapa)
    private val y = IntArray(mapa)

    private var serpiente = 0
    private var appleX = 0
    private var appleY = 0

    private var puntos = 0
    private var izquierda = false
    private var derecha = true
    private var arriba = false
    private var abajo = false
    private var inGame = 0

    private var timer: Timer? = null
    private var snake = Iconos.SERPIENTE.image
    private var apple = Iconos.MANZANA.image
    private var head = Iconos.CABEZA.image

    init {

        addKeyListener(Teclas())
        isFocusable = true

        preferredSize = Dimension(boardWidth, boardHeight)

        inicio()

    }

    //Esta funcion genera la serpiente, la manzana, el color del fondo y hace el refresco de la pantalla
    private fun inicio() {
        background = Color.black
        serpiente = 1

        for (z in 0 until serpiente) {
            x[z] = 50
            y[z] = 50
        }
        spawnApple()
        timer = Timer(delay, this)
        timer!!.start()
    }

    //Esta es una funcion que pinta en el layout del juego las imagenes de la serpiente y la manzana dependiendo de la posicion donde este
    public override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        points(g)
        doDrawing(g)
    }

    private fun doDrawing(g: Graphics) {

        if (inGame == 0) {

            g.drawImage(apple, appleX, appleY, this)

            for (images in 0 until serpiente) {
                if (images == 0) {
                    g.drawImage(head, x[images], y[images], this)
                } else {
                    g.drawImage(snake, x[images], y[images], this)
                }
            }

            Toolkit.getDefaultToolkit().sync()

        }
        if (inGame == 1) {

            gameOver(g)

        }
        if (inGame == 2) {

            victory(g)

        }
    }

    //Funcion que printa el mensaje de victoria
    private fun victory(g: Graphics) {

        val msg = "YOU WIN"
        val small = Font("Helvetica", Font.BOLD, 25)
        val fontMetrics = getFontMetrics(small)

        val rh = RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        )

        rh[RenderingHints.KEY_RENDERING] = RenderingHints.VALUE_RENDER_QUALITY

        (g as Graphics2D).setRenderingHints(rh)

        g.color = Color.green
        g.font = small
        g.drawString(
            msg, (boardWidth - fontMetrics.stringWidth(msg)) / 2,
            boardHeight / 2
        )
    }

    //Printa la puntuacion
    private fun points(g: Graphics) {
        val msg = "puntos: $puntos"
        val small = Font("Helvetica", Font.BOLD, 10)
        val fontMetrics = getFontMetrics(small)
        val rh = RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        )

        rh[RenderingHints.KEY_RENDERING] = RenderingHints.VALUE_RENDER_QUALITY

        (g as Graphics2D).setRenderingHints(rh)

        g.color = Color.white
        g.font = small
        g.drawString(
            msg, (boardWidth - fontMetrics.stringWidth(msg)) - 1,
            boardHeight - 1
        )

    }

    //Funcion que limpia todo y muestra el mensaje de game over
    private fun gameOver(g: Graphics) {

        val msg = "Game Over"
        val small = Font("Helvetica", Font.BOLD, 20)
        val fontMetrics = getFontMetrics(small)

        val rh = RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        )

        rh[RenderingHints.KEY_RENDERING] = RenderingHints.VALUE_RENDER_QUALITY

        (g as Graphics2D).setRenderingHints(rh)

        g.color = Color.red
        g.font = small
        g.drawString(
            msg, (boardWidth - fontMetrics.stringWidth(msg)) / 2,
            boardHeight / 2
        )
    }

    //Funcion que comprueba si en las posiciones adyacentes hay una manzana
    private fun checkApple() {

        if (x[0] == appleX && y[0] == appleY) {

            serpiente++
            puntos += 2
            spawnApple()
        }
        if (puntos == victoria) {
            inGame = 2
        }
    }

    //Funcion que mueve a la serpiente depeniendo de que movimiento haya recibido
    private fun movimiento() {

        for (z in serpiente downTo 1) {
            x[z] = x[z - 1]
            y[z] = y[z - 1]
        }

        if (izquierda) {
            x[0] -= dotSize
        } else if (derecha) {
            x[0] += dotSize
        } else if (arriba) {
            y[0] -= dotSize
        } else {
            y[0] += dotSize
        }
    }

    //Comprueba si la serpiente colisiona consigo misma o con el borde del mapa
    private fun checkCollision() {

        for (z in serpiente downTo 1) {
            if (z > 4 && x[0] == x[z] && y[0] == y[z]) {
                inGame = 1
            }
        }

        if (y[0] >= boardHeight) {
            inGame = 1
        } else if (y[0] < 0) {
            inGame = 1
        } else if (x[0] >= boardWidth) {
            inGame = 1
        } else if (x[0] < 0) {
            inGame = 1
        }

        if (inGame == 1) {
            timer!!.stop()
        }
    }

    //Funcion que hace aparecer una sola manzana de manera aleatoria por el mapa
    private fun spawnApple() {
        appleX = (0 until randPos).random() * dotSize
        appleY = (0 until randPos).random() * dotSize
    }

    //Funcion para que todo el juego funcione
    override fun actionPerformed(e: ActionEvent) {

        if (inGame == 0) {

            checkApple()
            checkCollision()
            movimiento()
        }

        repaint()
    }

    //Funcion para detectar teclas
    inner class Teclas : KeyAdapter() {

        override fun keyPressed(e: KeyEvent?) {

            val key = e!!.keyCode

            if (key == KeyEvent.VK_A && !derecha) {
                izquierda = true
                arriba = false
                abajo = false
            }

            if (key == KeyEvent.VK_D && !izquierda) {
                derecha = true
                arriba = false
                abajo = false
            }

            if (key == KeyEvent.VK_W && !abajo) {
                arriba = true
                derecha = false
                izquierda = false
            }

            if (key == KeyEvent.VK_S && !arriba) {
                abajo = true
                derecha = false
                izquierda = false
            }
        }
    }

}
