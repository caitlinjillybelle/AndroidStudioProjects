import android.content.Context
import android.content.res.AssetFileDescriptor
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.media.AudioManager
import android.media.SoundPool
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.IOException


internal class SnakeEngine : SurfaceView(), Runnable {
    fun SnakeEngine(context: Context, size: Point) {
        var context = context
        super(context)
        context = context
        screenX = size.x
        screenY = size.y

        // Work out how many pixels each block is
        blockSize = screenX / NUM_BLOCKS_WIDE
        // How many blocks of the same size will fit into the height
        numBlocksHigh = screenY / blockSize

        // Set the sound up
        soundPool = SoundPool(10, AudioManager.STREAM_MUSIC, 0)
        try {
            // Create objects of the 2 required classes
            // Use m_Context because this is a reference to the Activity
            val assetManager = context.assets
            var descriptor: AssetFileDescriptor

            // Prepare the two sounds in memory
            descriptor = assetManager.openFd("get_mouse_sound.ogg")
            eat_bob = soundPool.load(descriptor, 0)
            descriptor = assetManager.openFd("death_sound.ogg")
            snake_crash = soundPool.load(descriptor, 0)
        } catch (e: IOException) {
            // Error
        }


        // Initialize the drawing objects
        surfaceHolder = holder
        paint = Paint()

        // If you score 200 you are rewarded with a crash achievement!
        snakeXs = IntArray(200)
        snakeYs = IntArray(200)

        // Start the game
        newGame()
    }
}

// Our game thread for the main game loop
private val thread: Thread? = null

// To hold a reference to the Activity
private val context: Context? = null

// for plaing sound effects
private var soundPool: SoundPool? = null
private const var eat_bob = -1
private const var snake_crash = -1

// For tracking movement Heading
enum class Heading {
    UP, RIGHT, DOWN, LEFT
}

// Start by heading to the right
private val heading = Heading.RIGHT

// To hold the screen size in pixels
private const var screenX = 0
private const var screenY = 0

// How long is the snake
private const val snakeLength = 0

// Where is Bob hiding?
private const val bobX = 0
private const val bobY = 0

// The size in pixels of a snake segment
private const var blockSize = 0

// The size in segments of the playable area
private const val NUM_BLOCKS_WIDE = 40
private const var numBlocksHigh = 0

// Control pausing between updates
private const val nextFrameTime: Long = 0

// Update the game 10 times per second
private const val FPS: Long = 10

// There are 1000 milliseconds in a second
private const val MILLIS_PER_SECOND: Long = 1000
// We will draw the frame much more often

// We will draw the frame much more often
// How many points does the player have
private const val score = 0

// The location in the grid of all the segments
private var snakeXs: IntArray
private var snakeYs: IntArray

// Everything we need for drawing
// Is the game currently playing?
@Volatile
private val isPlaying = false

// A canvas for our paint
private val canvas: Canvas? = null

// Required to use canvas
private var surfaceHolder: SurfaceHolder? = null

// Some paint for our canvas
private var paint: Paint? = null