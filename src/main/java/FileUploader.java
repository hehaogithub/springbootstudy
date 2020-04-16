import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import org.xmlpull.v1.XmlPullParserException;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
public class FileUploader {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
        try {
            // Create a minioClient with the MinIO Server name, Port, Access key and Secret key.
            MinioClient minioClient = new MinioClient("http://192.168.192.51:9123", "wellcom", "Test1234!");

            // Check if the bucket already exists.
            boolean isExist = minioClient.bucketExists("test");
            if(isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // Make a new bucket called asiatrip to hold a zip file of photos.
                minioClient.makeBucket("test");
            }

            // Upload the zip file to the bucket with putObject
            minioClient.putObject("test","xx.jpg", "C:\\Users\\cjl\\Desktop\\timg.jpg",null);
            System.out.println("/home/user/Photos/asiaphotos.zip is successfully uploaded as asiaphotos.zip to `asiatrip` bucket.");
        } catch(MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
