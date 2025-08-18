#

## Đặt tên WAR đẹp trong Gradle

Trong file build.gradle, bạn thêm:

```
war {
    archiveFileName = "springmvc-thymeleaf.war"
}
```

Khi bạn chạy:

```
gradle clean build
```

File WAR sẽ nằm ở:

```
build/libs/springmvc-thymeleaf.war
```

Bạn chỉ cần copy nó vào thư mục:

```
$TOMCAT_HOME/webapps/
```

thì Tomcat sẽ chạy ứng dụng ở địa chỉ: [http://localhost:8080/springmvc-thymeleaf/](http://localhost:8080/springmvc-thymeleaf/)

## Đổi context path (nếu muốn)

### Đổi bằng tên WAR

- Nếu file WAR tên là app.war → context path sẽ là /app.
- Nếu muốn chạy ở / (root), đổi tên WAR thành ROOT.war.

