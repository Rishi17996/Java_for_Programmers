

/**
 * Purpose : This class extends Vehicle class, and collects information about
 * object SwiftDzire.
 *
 * Date : October 13,2018
 *
 *
 * @author Hitesh Shinde
 * @version 1.0
 */
public class SwiftDzire extends Vehicle {

    final String[] BODYKITS = {"Full Body Kit", "Ground Effects Kit"};
    final String[] TRANSMISSIONTYPE = {"Automatic", "Manual"};
    int bodyKits = -1;
    int transmissionType = -1;
    private double mpg = 0;

    /**
     * The default constructor SwiftDzire() has commonAttributes() for common
     * attributes, showMenu() to determine type of body kit & transmission &
     * gasMileage() for getting the mileage.
     */
    public SwiftDzire() {

        commonAttributes("Entering SwiftDzire order :");
                
        bodyKits = showMenu("What type of body kit do you want ?", BODYKITS);

        transmissionType = showMenu("What type of transmission do you want ?", TRANSMISSIONTYPE);

        gasMileage();
    }

    /**
     * The setBodyKits() is used to set the car body kit with validation.
     *
     * @param arrayIndex which is the users input choice .
     */
    public void setBodyKits(int arrayIndex) {

        if (arrayIndex >= 0 && arrayIndex <= 2) {
            bodyKits = arrayIndex;
        }
    }

    /**
     * The getBodyKits() is used to get the value of array BODYKITS.
     *
     * @return returns the array value of BODYKITS.
     */
    public String getBodyKits() {
        return BODYKITS[bodyKits];
    }

    /**
     * The setTransmissionType() is used to set the transmission type with
     * validation.
     *
     * @param arrayIndex which is the users input choice.
     */
    public void setTransmissionType(int arrayIndex) {
        if (arrayIndex >= 0 && arrayIndex <= 1) {
            transmissionType = arrayIndex;
        }
    }

    /**
     * The getTransmissionType() is used to get the value of array
     * TRANSMISSIONTYPE.
     *
     * @return returns the array value of TransmissionType.
     */
    public String getTransmissionType() {
        return TRANSMISSIONTYPE[transmissionType];
    }

    /**
     * The gasMileage() method is used to calculate the Mileage of SwiftDzire.
     * final static double mpgFullBodyKit = 20; final static double
     * mpgGroundEffectsKit = 25; final static double mpgAutomatic = 5;
     * Implement these values in Vinfo Interface.
     * @return mpg which returns the mileage.
     */
    public double gasMileage() {

        if (this.getBodyKits().equals("Full Body Kit")) {
            mpg = mpgFullBodyKit;
        } else if (this.getBodyKits().equals("Ground Effects Kit")) {
            mpg = mpgGroundEffectsKit;
        }
        /*
        * If the transmission is Automatic then it will reduce the mileage
        * of SwiftDzire.
         */

        if (this.getTransmissionType().equals("Automatic")) {
            mpg = mpg - mpgAutomatic;
        }

        return mpg;
    }

    /**
     * The setgasMileage() is used to set the value of mileage of SwiftDzire.
     *
     * @param mpg it takes input from gasMileage().
     */
    public void setgasMileage(double mpg) {
        this.mpg = mpg;
    }

    /**
     * The getgasMileage() is used to get the value of mileage.
     *
     * @return mpg returns the mileage.
     */
    public double getgasMileage() {
        return mpg;
    }

    /**
     * This toString() is used to display the formated output.
     *
     * @return formated output.
     */
    public String toString() {
        return "SwiftDzire: " + super.toString() + "\n" + "\t" + "MPG/GPH: " + this.getgasMileage() + "\n" + "\t" + "Body Kit Type: " + this.getBodyKits()
                + "\n" + "\t" + "Transmission Type: " + this.getTransmissionType();

    }
}
