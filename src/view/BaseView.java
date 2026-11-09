package view;

import dto.ResponseDTO;

public class BaseView {

    private ResponseDTO responseDTO;

    //nhan du lieu tu controller
    public void setResponseDTO(ResponseDTO responseDTO) {
        this.responseDTO = responseDTO;
    }

    //in thong bao ra man hinh
    public void displayMessages() {
        System.out.println(responseDTO.getMessage());
    }
}