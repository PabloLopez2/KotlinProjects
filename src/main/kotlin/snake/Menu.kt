import javax.swing.GroupLayout
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JLabel

class Menu(title: String) : JFrame() {

    init {
        createUI(title)
    }

    //Esta funcion genera la interfaz grafica con los elementos
    private fun createUI(title: String) {

        setTitle(title)

        val titulo = JLabel("SNAKE")
        val facil = JButton("FACIL")
        val normal = JButton("NORMAL")
        val dificil = JButton("DIFICIL")

        titulo.font = titulo.font.deriveFont(50F)

        facil.addActionListener { Snake(1).isVisible = true }
        normal.addActionListener { Snake(2).isVisible = true }
        dificil.addActionListener { Snake(3).isVisible = true }
        createLayout(titulo, facil, normal, dificil)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(400, 300)
        setLocationRelativeTo(null)
    }

    //Esta funcion crea el panel donde se mostrara junto con la configuracion para mover el texto
    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true
        gl.autoCreateGaps = true
        gl.setHorizontalGroup(
            gl.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(arg[0]).addGap(60, 150, Integer.MAX_VALUE)
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
        )

        gl.setVerticalGroup(
            gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(30).addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
        )
        pack()
    }
}

fun showUI() {

    val frame = Menu("Snake")
    frame.isVisible = true
}
