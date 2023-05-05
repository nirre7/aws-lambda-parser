package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TvSpotParserHandler implements RequestHandler<RequestDto, List<SpotDto>> {

    @Override
    public List<SpotDto> handleRequest(RequestDto s, Context context) {

        GetExcelFileFromS3Service getExcelFileFromS3Service = new GetExcelFileFromS3Service();
        ParseExcelFileService parseExcelFileService = new ParseExcelFileService();
        List<SpotDto> spotDtos = new ArrayList<>();

        try {

            InputStream file = getExcelFileFromS3Service.getFile();
            spotDtos = parseExcelFileService.parse(file);

        } catch (IOException e) {
            context.getLogger().log("Could not fetch file from s3 :(");
        }

        return spotDtos;
    }
}
