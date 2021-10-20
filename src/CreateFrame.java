import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class CreateFrame {
	private JPanel panel;
	private JPanel itemsPanel;
    private JFrame frame;
    private JList todoItemsList;
    private Container contentPane;

	CreateFrame(ArrayList<String> items){
		frame = new JFrame("Todo List");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        panel = new JPanel();
        panel.setName("Main Panel");
        panel.setLayout(new BorderLayout());
        
        todoItemsList = new JList();
        todoItemsList.setName("todolist");
        
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BorderLayout());
        itemsPanel.add(new JLabel("Todo items:"), BorderLayout.NORTH);
        itemsPanel.add(todoItemsList, BorderLayout.CENTER);
        panel.add(itemsPanel, BorderLayout.CENTER);
        
        contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(panel, BorderLayout.CENTER);
        
        updateTodoItems(items);
        frame.pack();
        frame.setVisible(true);

	}
	
    private void updateTodoItems(ArrayList<String> items) {
        todoItemsList.setListData(items.toArray());
    }
    
}
