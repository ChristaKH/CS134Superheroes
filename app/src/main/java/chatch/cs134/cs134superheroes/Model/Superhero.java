package chatch.cs134.cs134superheroes.Model;

public class Superhero {
    private String mImageName;
    private String mName;
    private String mSuperpower;
    private String mOneThing;

    public Superhero(String imageName, String name, String superpower, String oneThing) {
        mImageName = imageName;
        mName = name;
        mSuperpower = superpower;
        mOneThing = oneThing;
    }

    public Superhero(){
        mImageName = "";
        mName = "";
        mSuperpower = ";";
        mOneThing = "";
    }

    public String getImageName() {
        return mImageName;
    }

    public void setImageName(String imageName) {
        mImageName = imageName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSuperpower() {
        return mSuperpower;
    }

    public void setSuperpower(String superpower) {
        mSuperpower = superpower;
    }

    public String getOneThing() {
        return mOneThing;
    }

    public void setOneThing(String oneThing) {
        mOneThing = oneThing;
    }

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
