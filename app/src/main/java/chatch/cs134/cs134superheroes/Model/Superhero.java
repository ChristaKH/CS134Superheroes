/**
 * Class that describes a single Superhero. This includes their name,
 * their superpower, their one thing, and the file name for the image
 * of this superhero
 */
package chatch.cs134.cs134superheroes.Model;

public class Superhero {
    private String mImageName;
    private String mName;
    private String mSuperpower;
    private String mOneThing;

    /**
     * Full constructor that describes every aspect of a superhero
     * @param imageName String name of the the image file
     * @param name  String name of the superhero
     * @param superpower    String describing the superhero's superpower
     * @param oneThing  String describing a unique aspect of this hero
     */
    public Superhero(String imageName, String name, String superpower, String oneThing) {
        mImageName = imageName;
        mName = name;
        mSuperpower = superpower;
        mOneThing = oneThing;
    }

    /**
     * Empty constructor that sets all the instance variables to empty Strings
     */
    public Superhero(){
        mImageName = "";
        mName = "";
        mSuperpower = ";";
        mOneThing = "";
    }

    /**
     * Method that returns the name of the image file for the superhero
     * @return  Hero's image name
     */
    public String getImageName() {
        return mImageName;
    }

    /**
     * Method that sets the name of the image file for a superhero
     * @param imageName New image file name
     */
    public void setImageName(String imageName) {
        mImageName = imageName;
    }

    /**
     * Method that returns the name of a superhero
     * @return  Name of this superhero
     */
    public String getName() {
        return mName;
    }

    /**
     * Method that sets the name of this superhero
     * @param name  New name of this superhero
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Method that returns the superpower of this current hero
     * @return  This superhero's superpower
     */
    public String getSuperpower() {
        return mSuperpower;
    }

    /**
     * Method that sets the superpower of this superhero
     * @param superpower    New superpower for this superhero
     */
    public void setSuperpower(String superpower) {
        mSuperpower = superpower;
    }

    /**
     * Method that returns the one thing of this superhero
     * @return  The One Thing of this superhero
     */
    public String getOneThing() {
        return mOneThing;
    }

    /**
     * Sets the One Thing of this hero
     * @param oneThing  New One Thing for this hero
     */
    public void setOneThing(String oneThing) {
        mOneThing = oneThing;
    }

    /**
     * Method that returns a String summary of this superhero
     * @return  String summary of this superhero
     */
    @Override
    public String toString() {
        return "Superhero{" +
                "mImageName='" + mImageName + '\'' +
                ", mName='" + mName + '\'' +
                ", mSuperpower='" + mSuperpower + '\'' +
                ", mOneThing='" + mOneThing + '\'' +
                '}';
    }
}
