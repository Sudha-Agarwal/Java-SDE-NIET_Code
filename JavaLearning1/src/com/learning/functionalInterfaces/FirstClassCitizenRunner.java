package com.learning.functionalInterfaces;

@FunctionalInterface
interface Rule{
   String print();
   int x=10;
   //introduced in java8 - default methods in interface
   default void print1(){
   }
    default void print2(){
    }
    static void print3(){
    }
}

@FunctionalInterface
interface Sum{
    int add(int num1, int num2);
}

interface Square{
    int sqr(int num);
}

/*class RuleImplementer implements Rule{
    @Override
    public void print(){
        System.out.println("printing");
    }
}*/

public class FirstClassCitizenRunner {

    //passing function as a parameter(Higher Order Function)
    static String operate(Rule obj){
        return obj.print();
    }

    public static void main(String[] args) {
        Rule obj = new Rule(){
            @Override
            public String print(){
                //System.out.println("printing");
                return "printing";
            }
        };
        System.out.println(obj.print());

        //lambda expression
        Rule obj1 = ()-> "printing";
        System.out.println(obj1.print());

        Sum obj2 = new Sum(){
            public int add(int num1, int num2){
                return num1+num2;
            }
        };
        int res = obj2.add(2,3);
        Sum obj3 = (num1, num2) -> num1+num2;
        int result = obj3.add(2,3);
        System.out.println(result);
        Square obj4 = num->num*num;
        System.out.println(obj4.sqr(5));

        //passing function as an argument
        String response = operate(new Rule() {
            @Override
            public String print() {
                return "passing function as an argument";
            }
        });

        System.out.println(response);
        String response1 = operate(()-> "passing function as an argument");
        System.out.println(response1);

        String response2 = operate(obj1);
        System.out.println(response2);
    }
}
