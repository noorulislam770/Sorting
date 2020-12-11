package sortingapp;

import java.util.Scanner;

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
      System.out.println("\n=================================================\n");
      int [] arrOfNums = {1,2,3,4,5,6,7,8,9,10};
      System.out.println("array Given : ");
      System.out.print("[");
      for (int i: arrOfNums){
        System.out.print(i + " ");
      }
      System.out.print("] \n");
      System.out.println("-----------------------------------");
      reverseStack(arrOfNums);
      System.out.println("array Traversed : ");
      System.out.print("[");
      for (int i: arrOfNums){
        System.out.print(i + " ");
      }
      System.out.print("] \n");
      System.out.println("\n----------------------------------------- Expression Precedence Using Stack ---------------");
      String Expressin = "{12+13}(23*2(9-3(23+1)(23/3))[90-90(2232*23)])";
      // Expressin = "()";
      boolean isTrue = verifyExpression(Expressin);
      System.out.println("Expression is balenced : " + isTrue);
    
      System.out.println("\n------------------------------- Palaindrom ------------------");
      Scanner in = new Scanner (System.in);

      System.out.println("Enter the sequence : ");
      String seq = in.nextLine();
      System.out.println("if is Palaindrom : " + PalandromCheck(seq));


      
    
    }



    public static boolean PalandromCheck(String seq){
      seq = seq.toLowerCase();
      CharStack palndromStk = new CharStack(seq.length());

      for (int i = seq.length() - 1 ;i >= 0;i --){
        palndromStk.push(seq.charAt(i));
      }

      for (int i = seq.length() - 1 ; i >=  0 ;i--){
        if (seq.charAt(i) != palndromStk.pop()){
          return false;
        }
      }

      return true;

    }

    public static int [] reverseStack(int[] stackIn){

      MyStack stack = new MyStack(stackIn.length);
      for (int num : stackIn){
        stack.push(num);
      
      }
      for (int i =0; i < stackIn.length;i++){
        int value = stack.pop();
        stackIn[i] = value;
      }
      return stackIn;
      
    }






    public static boolean verifyExpression(String exp){
      int len = exp.length();
      CharStack stk = new CharStack(len);
      for (int i = 0; i < len;i++){
        char c = exp.charAt(i);
        if (c == '(' || c == '[' || c == '{'){
          stk.push(c);
        }
        else if (c == ')' || c == ']' || c == '}'){
          if (!stk.isEmpty()){
            char prevBracket = stk.pop();
            if (prevBracket == '(' && c != ')' ){
              return false;
            }
            else if (prevBracket == '[' && c != ']' ){
              return false;
            }
            else if (prevBracket == '{' && c != '}' ){
              return false;
            }
          }
        }
      }
      return true;
    }
    
  }
  

