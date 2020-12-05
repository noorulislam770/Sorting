package sortingapp;


class StackApp {
    public static void main(String[] args) {
      
      System.out.println("Hello Codiva");
      
      int valuepopped;
      MyStack stk = new MyStack(15);
      stk.push(23);
      stk.push(903);
      stk.push(2903);
      stk.push(2443);
      stk.push(2893);
      stk.push(89);
      stk.push(613);
      stk.push(983);
      System.out.print("[");
      for (int i: stk.stack){
        System.out.print(i + " ");
      }
      System.out.print("] \n");
      
      
      valuepopped = stk.pop();
      valuepopped = stk.pop();
      valuepopped = stk.pop();
      valuepopped = stk.pop();
      stk.push(43);
      
      stk.peek();
      
      System.out.print("[");
      for (int i: stk.stack){
        System.out.print(i + " ");
      }
      System.out.print("] \n");
      
    }
  }
  
