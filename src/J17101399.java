import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.lang.Math;
import javax.swing.JFrame;
import java.util.Scanner;

class ThirdGLEventListener implements GLEventListener {
    /**
     * Interface to the GLU library.
     */
    private GLU glu;

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-500, -500, 500, 500);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-500.0, 500.0, -500.0, 500.0);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        /*
         * put your code here
         */
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any integer between -500 to 500");
        int h1=sc.nextInt();
        System.out.println("Enter another integer between -500 to 500");
        int h2=sc.nextInt();
        int plus_x=h2/2;
        int plus_y=h1/2;
        int minus_x=plus_x*(-1);
        int minus_y=plus_y*(-1);
        gl.glLineWidth(3.0f);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(plus_x, plus_y);
        gl.glVertex2d(minus_x, plus_y);
        gl.glVertex2d(minus_x, plus_y);
        gl.glVertex2d(minus_x, minus_y);
        gl.glVertex2d(minus_x, minus_y);
        gl.glVertex2d(plus_x, minus_y);
        gl.glVertex2d(plus_x, minus_y);
        gl.glVertex2d(plus_x, plus_y);
        gl.glEnd();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
                        int height) {
    }

    public void displayChanged(GLAutoDrawable drawable,
                               boolean modeChanged, boolean deviceChanged) {
    }

    public void dispose(GLAutoDrawable arg0)
    {

    }
}
public class J17101399
{
    public static void main(String args[])
    {
        //getting the capabilities object of GL2 profile
        final GLProfile profile=GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities=new GLCapabilities(profile);
        // The canvas
        final GLCanvas glcanvas=new GLCanvas(capabilities);
        ThirdGLEventListener b=new ThirdGLEventListener();
        glcanvas.addGLEventListener(b);
        glcanvas.setSize(1024, 720);
        //creating frame
        final JFrame frame=new JFrame("Basic frame");
        //adding canvas to frame
        frame.add(glcanvas);
        frame.setSize(1024,720);
        frame.setVisible(true);
    }
}