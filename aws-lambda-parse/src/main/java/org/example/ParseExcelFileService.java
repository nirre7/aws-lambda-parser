package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ParseExcelFileService {

    public List<SpotDto> parse(InputStream file) throws IOException {

        List<SpotDto> parsedRows = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {

            if (row.getRowNum() > 15) {
                Cell channel = row.getCell(0);
                if (channel != null) {
                    SpotDto dto = createDtoFromRow(row);
                    parsedRows.add(dto);
                }
            }
        }

        file.close();

        return parsedRows;
    }

    private SpotDto createDtoFromRow(Row row) {

        SpotDto dto = new SpotDto();

        try {
            dto.setChannel(row.getCell(0).getStringCellValue());
            dto.setDate(row.getCell(1).getDateCellValue());
            dto.setTime(row.getCell(2).getNumericCellValue());
            dto.setProgrammeAfter(row.getCell(3).getStringCellValue());
            dto.setPibPosition(row.getCell(4).getNumericCellValue());
            dto.setPibCount(row.getCell(5).getNumericCellValue());
            dto.setFilmCode(row.getCell(6).getStringCellValue());
            dto.setSpotLengthInSeconds(row.getCell(7).getNumericCellValue());
            dto.setTrpInTa(row.getCell(8).getNumericCellValue());
            dto.setTrp30InTa(row.getCell(9).getNumericCellValue());
            dto.setTrpInA18(row.getCell(10).getNumericCellValue());
            dto.setOnePlusInTa(row.getCell(11).getNumericCellValue());
            dto.setTwoPlusInTa(row.getCell(12).getNumericCellValue());
            dto.setThreePlusInTa(row.getCell(13).getNumericCellValue());
            dto.setFourPlusInTa(row.getCell(14).getNumericCellValue());
            dto.setFivePlusInTa(row.getCell(15).getNumericCellValue());
            dto.setSixPlusInTa(row.getCell(16).getNumericCellValue());
            dto.setSevenPlusInTa(row.getCell(17).getNumericCellValue());
            dto.setEightPlusInTa(row.getCell(18).getNumericCellValue());
            dto.setNinePlusInTa(row.getCell(19).getNumericCellValue());
            dto.setTenPlusInTa(row.getCell(20).getNumericCellValue());
            dto.setUniqueInTa(row.getCell(21).getNumericCellValue());
        } catch (Exception e) {
            // nah ..
        }

        return dto;
    }
}
