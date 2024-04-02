public class IntParser implements Parser<Integer>{
    @Override
    public Integer parse(String string) {
        return Integer.parseInt(string);
    }
}