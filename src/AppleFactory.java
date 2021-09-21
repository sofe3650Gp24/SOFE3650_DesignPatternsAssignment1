public class AppleFactory extends AppleAbstract {

    public AppleFactory getProduct(String productType) {

        if(productType.equals("iPhone")) {
            return new AppleFactory() {

            };
        }
        return null;
    }
}
