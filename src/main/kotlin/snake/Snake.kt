import javax.swing.JFrame

class Snake(private val difficulty: Int) : JFrame() {
    init {
        initUI()
    }

    //Esta funcion inicia el layout dependiendo de que se haya seleccionado anteriormente
    private fun initUI() {
        if (difficulty == 1) {
            add(Pantalla(100, 100, 100, 10, 250, 20))
        }
        if (difficulty == 2) {
            add(Pantalla(150, 150, 225, 15, 200, 75))
        }
        if (difficulty == 3) {
            add(Pantalla(300, 300, 900, 25, 150, 150))
        }
        title = "Snake"

        isResizable = false
        pack()

        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
    }

}