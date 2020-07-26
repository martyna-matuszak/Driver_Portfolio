package pl.coderslab.driver.dto;

public class FileDto {

    private Long id;
    private String url;
    private String fileName;
    private String fileType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "FileDto:" +
                "\n id = " + id +
                "\n url = " + url +
                "\n fileName = " + fileName +
                "\n fileType = " + fileType;
    }
}
