package repository;

import model.BaseNumber;

public class BaseRepository {

    //so goc do nguoi dung nhap
    private BaseNumber originalNumber;

    //luu so goc
    public void save(BaseNumber number) {
        this.originalNumber = number;
    }

    //lay so goc
    public BaseNumber get() {
        return originalNumber;
    }
}