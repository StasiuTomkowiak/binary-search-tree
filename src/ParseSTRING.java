public class ParseSTRING implements Pareser<String>{
    @Override
    public String parse(String variable) {
        return variable.toString();
    }
    
}
