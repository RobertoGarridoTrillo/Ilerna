package teclas;

import java.awt.event.KeyEvent;

public class RecogeTeclas extends Clasificador {

    // Field attributes
    private String key;
    private int keyCode;
    
    // methods
    public void keyPressed(KeyEvent e) {
        // reading keys
        key =String.valueOf(e.getKeyChar());
        keyCode = e.getKeyCode();
        
        //System.out.println(e.getKeyChar());
        // sorting keys
        if ( (keyCode >= 48 && keyCode <= 57) || (keyCode >= 96 && keyCode <= 105) ) {
            vk_number(key); 
        }
        
        switch (keyCode) {
            case (KeyEvent.VK_BACK_SPACE): vk_back_space(); break;
            case (KeyEvent.VK_DELETE): vk_delete(); break;
            case (KeyEvent.VK_HOME): vk_home(); break;
            
            case (KeyEvent.VK_ADD): vk_operator("+"); break;            
            case (KeyEvent.VK_SUBTRACT): vk_operator("-"); break;            
            case (KeyEvent.VK_MULTIPLY): vk_operator("*"); break;           
            case (KeyEvent.VK_DIVIDE): vk_operator("/"); break; 
                        
            case (KeyEvent.VK_DECIMAL): vk_decimal(); break;
            case (KeyEvent.VK_PAGE_DOWN): vk_page_down(); break;
            
            case (KeyEvent.VK_ENTER): vk_enter(); break;            
            case (KeyEvent.VK_ESCAPE): vk_exit(); break;            
            
        }
    }
}
