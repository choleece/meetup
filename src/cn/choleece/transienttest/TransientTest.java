package cn.choleece.transienttest;

import java.io.*;

/**
 * Created by choleece on 2018/5/27.
 */
public class TransientTest {
    public static void main(String[] args) {
        User user = new User("choleece", "qdwps520");
        user.setGender("M");
        System.out.println("read before serializable~userName: " + user.getUserName() + " password: " + user.getPassword() + " gender: " + user.getGender());

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/Users/choleece/Desktop/user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            User.gender = "F";
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/choleece/Desktop/user.txt"));
            user = (User) in.readObject();
            System.out.println("read after serializable~userName: " + user.getUserName() + " password: " + user.getPassword() + " gender: " + user.getGender());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
