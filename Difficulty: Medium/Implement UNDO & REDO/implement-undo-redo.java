import java.util.Stack;

class Solution {
    
    private StringBuilder document = new StringBuilder();
    private Stack<Character> undoStack = new Stack<>();
    private Stack<Character> redoStack = new Stack<>();

    public void append(char x) {
        document.append(x);
        undoStack.push(x);
        redoStack.clear(); // clear redo history on new append
    }

    public void undo() {
        if (document.length() > 0) {
            char removed = document.charAt(document.length() - 1);
            document.deleteCharAt(document.length() - 1);
            redoStack.push(removed);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            char restored = redoStack.pop();
            document.append(restored);
            undoStack.push(restored);
        }
    }

    public String read() {
        return document.toString();
    }
}
