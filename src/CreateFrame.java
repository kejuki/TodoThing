import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CreateFrame {
	private JPanel panel;
	private JPanel itemsPanel;
    private JFrame frame;
    private JList<String> todoItemsList;
    private Container contentPane;

	CreateFrame(ArrayList<Item> items){
		DefaultListModel<String> model = new DefaultListModel<>();
		
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent listSelectionEvent) {
		        boolean adjust = listSelectionEvent.getValueIsAdjusting();
		        if (!adjust) {
		          JList list = (JList) listSelectionEvent.getSource();
		          int selections[] = list.getSelectedIndices();
		          for (int i = 0, n = selections.length; i < n; i++) {
		            items.get(selections[i]).setItemState(!items.get(selections[i]).isItemState());
		            updateTodoItems(items, model);
		          }
		        }
		      }
	    };
	    
		frame = new JFrame("Todo List");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        panel = new JPanel();
        panel.setName("Main Panel");
        panel.setLayout(new BorderLayout());
        
        
        todoItemsList = new JList(model);
        todoItemsList.setName("todolist");
        todoItemsList.addListSelectionListener(listSelectionListener);
        
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BorderLayout());
        itemsPanel.add(new JLabel("Todo items:"), BorderLayout.NORTH);
        itemsPanel.add(todoItemsList, BorderLayout.CENTER);
        panel.add(itemsPanel, BorderLayout.CENTER);
        
        contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(panel, BorderLayout.CENTER);
        
        updateTodoItems(items, model);
        frame.pack();
        frame.setVisible(true);

	}
	
    private void updateTodoItems(ArrayList<Item> items, DefaultListModel<String> model) {
    	model.clear();
        for(Item item : items) {
    		model.addElement("task: " + item.getItem() + " | is done: " + item.isItemState() );

        }
    }
    
}
