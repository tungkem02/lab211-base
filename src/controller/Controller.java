package controller;

import constants.Base;
import constants.Message;
import dto.BaseDTO;
import dto.ResponseDTO;
import service.BaseService;
import view.BaseView;

public class Controller {

    private BaseDTO baseDto;
    private BaseView baseView;

    //khoi tao view de hien thi ket qua
    public Controller() {
        baseView = new BaseView();
    }

    //nhan du lieu da validate tu Main
    public void setDto(BaseDTO dto) {
        this.baseDto = dto;
    }

    //chuyen doi so va hien thi ket qua
    public void convertNumber() {
        BaseService baseService = new BaseService(baseDto);
        String result;
        //he xuat la thap phan -> doi thang sang thap phan
        if (baseDto.getTargetBase() == Base.DEC) {
            result = baseService.convertToDec();
        } else {
            //he xuat la BIN hoac HEX
            result = baseService.convertDecOut(baseDto.getTargetBase());
        }
        ResponseDTO response = new ResponseDTO();
        response.setMessage(String.format(Message.CONVERT_SUCCESS, result));
        //dat du lieu vao view truoc roi moi hien thi
        baseView.setResponseDTO(response);
        baseView.displayMessages();
    }
}