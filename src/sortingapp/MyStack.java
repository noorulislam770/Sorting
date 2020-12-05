package sortingapp;


class MyStack {
  
  
    private int size;
    public int [] stack;
    private int top;
    
    public MyStack(int size){
      this.size = size;
      stack = new int[size];
      top = -1;
    }
    
    public int peek(){
      if (!isFull()){
          System.out.println("peek : " + stack[top]);
        return stack[top];
      }
      return -0;
    }
    
    public int pop(){
      if (!isEmpty()){
          int value = stack[top];
          stack[top] = 0;
          top--;
          System.out.println("popped : " + value);
        return value;
      }
      return -0;
    }
    
    
    public void push(int value){
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
  