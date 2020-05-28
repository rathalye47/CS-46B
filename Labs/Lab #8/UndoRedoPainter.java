package stacklab;

import java.util.*;


public class UndoRedoPainter extends Painter
{
	public UndoRedoPainter()
	{
		super();
		setUndoButtonEnabled(false);
		setRedoButtonEnabled(false);
	}
	
	// Called when the user pushes the Undo button.
	void undo()
	{
		Circle removed = getHistory().pop();
		getUndoHistory().push(removed);
		if(getHistory().isEmpty())
			setUndoButtonEnabled(false);
		setRedoButtonEnabled(true);
		repaint();
	}


	// Called when the user pushes the Redo button.
	void redo()
	{
		Circle replaced = getUndoHistory().pop();
		getHistory().push(replaced);
		if(getUndoHistory().isEmpty())
			setRedoButtonEnabled(false);
		setUndoButtonEnabled(true);
		repaint();
	}
	
	
	public static void main(String[] args)
	{
		new UndoRedoPainter().setVisible(true);
	}
}
