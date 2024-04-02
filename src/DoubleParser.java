public class DoubleParser implements Parser<Double>{
    public Double parse(String string) {
        return Double.parseDouble(string);
    }
}
