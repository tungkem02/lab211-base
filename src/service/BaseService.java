package service;

import constants.Base;
import dto.BaseDTO;
import java.math.BigInteger;
import model.BaseNumber;
import repository.BaseRepository;

public class BaseService {

    private BaseRepository baseRepository;

    //nhan DTO, tao BaseNumber va luu vao repository
    public BaseService(BaseDTO dto) {
        baseRepository = new BaseRepository();
        baseRepository.save(new BaseNumber(dto.getSourceBase(), dto.getPresentation()));
    }

    //doi so goc sang he thap phan
    public String convertToDec() {
        BaseNumber number = baseRepository.get();
        BigInteger result = BigInteger.ZERO;
        BigInteger sourceBase = BigInteger.valueOf(number.getBase().getValue());
        BigInteger power = BigInteger.ONE;
        String text = number.getPresentation();
        //duyet tu phai sang trai
        for (int i = text.length() - 1; i >= 0; i--) {
            //gia tri chu so: '7' -> 7, 'A' -> 10
            BigInteger digit = BigInteger.valueOf(Character.getNumericValue(text.charAt(i)));
            //cong vao ket qua: chu so * luy thua cua co so
            result = result.add(digit.multiply(power));
            power = power.multiply(sourceBase);
        }
        return result.toString();
    }

    //doi so goc sang he dich (BIN, HEX hoac DEC)
    public String convertDecOut(Base targetBase) {
        BigInteger number = new BigInteger(convertToDec());
        BigInteger target = BigInteger.valueOf(targetBase.getValue());
        //so 0 khong vao vong lap nen tra ve luon
        if (number.equals(BigInteger.ZERO)) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        //chia lay du den khi so bang 0
        while (number.compareTo(BigInteger.ZERO) > 0) {
            int remainder = number.mod(target).intValue();
            number = number.divide(target);
            //du tu 10 tro len doi thanh chu cai A-F
            if (remainder >= 10) {
                result.insert(0, (char) ('A' + remainder - 10));
            } else {
                result.insert(0, remainder);
            }
        }
        return result.toString();
    }
}