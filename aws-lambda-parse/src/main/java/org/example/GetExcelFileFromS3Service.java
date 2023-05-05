package org.example;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GetExcelFileFromS3Service {

    public InputStream getFile() throws IOException {

        Region region = Region.EU_NORTH_1;
        S3Client s3Client = S3Client.builder()
                .region(region)
                .build();

        GetObjectRequest s3Request = GetObjectRequest.builder()
                .bucket("nisoexcelbucket")
                .key("TV_Spotlist_A18_49.xlsx")
                .build();

        ResponseInputStream<GetObjectResponse> responseInputStream = s3Client.getObject(s3Request);
        return new ByteArrayInputStream(responseInputStream.readAllBytes());
    }
}
