import android.app.Activity
import android.graphics.Point
import android.os.Bundle

class SnakeActivity : Activity() {
    // Declare an instance of SnakeEngine
    var snakeEngine: SnakeEngine? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the pixel dimensions of the screen
        val display = windowManager.defaultDisplay

        // Initialize the result into a Point object
        val size = Point()
        display.getSize(size)

        // Create a new instance of the SnakeEngine class
        snakeEngine = SnakeEngine(this, size)

        // Make snakeEngine the view of the Activity
        setContentView(snakeEngine)
    }

    // Start the thread in snakeEngine
    override fun onResume() {
        super.onResume()
        snakeEngine.resume()
    }
    // Stop the thread in snakeEngine
    override fun onPause() {
        super.onPause()
        snakeEngine.pause()
    }
}