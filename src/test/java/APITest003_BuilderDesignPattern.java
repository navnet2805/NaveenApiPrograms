public class APITest003_BuilderDesignPattern {
    //method name == class name
    //return this

    public APITest003_BuilderDesignPattern Step1()
    {
        System.out.println("Step1 started");
        System.out.println("Step1 return");

        return this;
    }

    public APITest003_BuilderDesignPattern Step2()
    {
        System.out.println("Step2 started");
        System.out.println("Step2 return");

        return this;
    }

    public APITest003_BuilderDesignPattern Step3(String name)
    {
        System.out.println("Step3 started");
        System.out.println("Step3 return : " +name);

        return this;
    }

    public static void main(String[] args) {
        APITest003_BuilderDesignPattern bp = new APITest003_BuilderDesignPattern();
        bp.Step1().Step2().Step3("Naveen");
    }


}
