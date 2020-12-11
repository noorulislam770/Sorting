package sortingapp;


class CharStack {
  
  
    private int size;
    public char [] stack;
    private int top;
    
    public CharStack(int size){
      this.size = size;
      stack = new char [size];
      top = -1;
    }

    
    
    public char peek(){
      if (!isFull()){
          System.out.println("peek : " + stack[top]);
        return stack[top];
      }
      return -0;
    }
    
    public char pop(){
      if (!isEmpty()){
          char value = stack[top];
          stack[top] = 0;
          top--;
          System.out.println("popped : " + value);
        return value;
      }
      return -0;
    }
    
    
    public void push(char value){
      if (!isFull()){
        top++;
        stack[top] = value;
        System.out.println("Pushed :" + value);
      }
    }
    
    public boolean isEmpty(){
      if (top <= -1){
        return true;
      }
      return false;
    }
    
    public boolean isFull(){
      if (top + 1 >= size){
        return true;
      }
      return false;
    }
    
    public int top(){
      return top;
    }
    
    
  }
  