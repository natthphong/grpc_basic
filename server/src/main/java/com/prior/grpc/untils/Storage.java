package com.prior.grpc.untils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Storage {

    private  final ByteArrayOutputStream outputStream ;


    public Storage() {
        this.outputStream = new ByteArrayOutputStream();
    }

    public ByteArrayOutputStream getOutputStream(){
        return this.outputStream;
    }
    public void write(String fileNameType)  throws IOException {
        System.out.println("write na ja");
        String path ="images/";
        try(FileOutputStream fileOutputStream = new FileOutputStream(path.concat(fileNameType))) {
                this.outputStream.writeTo(fileOutputStream);
        }
    }
    public void  close() throws  IOException{
        this.outputStream.close();
    }
}
