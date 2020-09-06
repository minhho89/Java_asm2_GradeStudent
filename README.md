# Java_asm2_GradeStudent
Hướng dẫn dự án

Mô tả ứng dụng

Grade Student là ứng dụng cho phép người dùng nhập thông tin về điểm số của sinh viên sau đó hệ thống sẽ tính toán để đưa ra Grade phù hợp cho sinh viên đó (dựa vào các giá trị đã nhập vào và quy tắc xếp loại của trường).  

Ứng dụng cần phải đảm bảo các chức năng cơ bản. Tuy nhiên, bạn có thể thêm chức năng bổ sung vào ứng dụng của bạn, nếu bạn muốn.

Phần 1: Chức năng và yêu cầu cơ bản

1. Thiết kế giao diện

Giao diện đơn thuần dạng console 
Hiển thị thông tin thành khối rõ ràng và dễ nhìn
Screenshot 2019-06-15 at 16.23.28.png

Hình trên là màn hình là ví dụ một log console của hệ thống.

2. Yêu cầu chức năng cơ bản

1. Khi chương trình được chạy, thì đầu tiên, sẽ hiển thị thông báo mô tả ngắn gọn về chương trình để người dùng hiểu được hệ thống này sẽ hoạt động thế nào, có chức năng gì. Ví dụ trong log trên thì thông báo hiển thị là: “This program reads exam/homework scores and reports your overall course grade”. 

2. Sau đó, người dùng sẽ nhập điểm thi giữa kỳ - Midterm: Trong điểm thi giữa kỳ thì thông tin cần nhập là: 

Weight (0-100): tức là trọng số của điểm thi giữa kỳ, và trọng số có giá trị là số nguyên dương sẽ nằm trong khoảng từ 0 tới 100. Ví dụ trong này là 20.
Score earned: là điểm số mà người dùng đã đạt được. Ví dụ trong này là 78. 
Were scores shifted (1 = yes, 2=no): là điểm thi bạn có được tăng không, chọn 1 nếu có, chọn 2 nếu không. Ví dụ trong này là 2, có nghĩa là không được tăng.  Vì không được tăng, nên dòng thông tin sau sẽ hiển thị luôn total points. 
Total points: là tổng số điểm, bao gồm điểm ban đầu và số điểm được tăng thêm, điểm tối đa của total point là 100. Ví dụ trong này điểm sẽ là 78 + 0  = 78. 
Weighted score: Là điểm số đã tính dựa trên trọng số. Ví dụ trong này sẽ là weighted score =  (78/100) * 20 = 15.6 . 15.6 là điểm số tính trên thang điểm 20. 
3. Tiếp theo, người dùng sẽ nhập điểm thi cuối kỳ - Final: Trong điểm thi cuối kỳ thì thông tin cần nhập là:

Weight (0-100): tức là trọng số của điểm thi giữa kỳ, và trọng số có giá trị là số nguyên dương sẽ nằm trong khoảng từ 0 tới 100. Ví dụ trong này là 35.
Score earned: là điểm số mà người dùng đã đạt được. Ví dụ trong này là 95. 
Were scores shifted (1 = yes, 2=no): là điểm thi bạn có được tăng không, chọn 1 nếu có, chọn 2 nếu không. Ví dụ trong này là 1, có nghĩa là được tăng. Vì là được tăng, nên sau dòng này sẽ có dòng nhập Shift amount. 
Shift amount:  là số điểm mà đã được tăng. Ví dụ trong này là 10. 
Total points: là tổng số điểm, bao gồm điểm ban đầu và số điểm được tăng thêm, điểm tối đa của total point là 100. Ví dụ trong này điểm sẽ là 95 + 10 = 105. Nhưng maximum của total points là 100 thôi, nên total sẽ chỉ được tính là 100. 
Weighted score: Là điểm số đã tính dựa trên trọng số. Ví dụ trong này sẽ là weighted score =  (100/100) * 35 = 35.0/35 . 35 là điểm số tính trên thang điểm 35. 
4. Cuối cùng, người dùng sẽ nhập điểm bài tập về nhà- Homework: Trong điểm bài tập về  thì thông tin cần nhập là:

- Weight (0-100): tức là trọng số của điểm bài tập về nhà, và trọng số có giá trị là số nguyên dương sẽ nằm trong khoảng từ 0 tới 100. Ví dụ trong này là 45. (phải đảm bảo tổng 3 trọng số chính xác là 100).

- Number of assignments: là tổng số bài tập về nhà cần làm. Ví dụ trong này là 3 assignment. 

- Theo đó số lượng đầu điểm cần nhập là 3 đầu điểm assignment. Với mỗi đầu điểm assignment thì sinh viên cần nhập cả 2 tham số là score và max. 

Assignment 1 score and max:  18 20 trong đó 18 là điểm số thực của sinh viên đạt được, và 20 là điểm tối đa của bài assignment 1. 
Assignment 2 score and max:  29 32 trong đó 29 là điểm số thực của sinh viên đạt được, và 32 là điểm tối đa của bài assignment 2. 
Assignment 3 score and max:  31 40 trong đó 31 là điểm số thực của sinh viên đạt được, và 40 là điểm tối đa của bài assignment 3. 
- How many sections did you attend: 4 là số lượng buổi học sinh viên đã đi học và được điểm danh. Điểm này có thể hiểu là tính điểm chuyên cần cho sinh viên. 

- Section points: Là tổng số điểm chuyên cần của sinh viên, với mỗi buổi được điểm danh, thì sinh viên sẽ được tính 5 điểm. Và tối đa điểm tính cho phần chuyên cần (attend) này là 30. Trong trường hợp này điểm chuyên cần của sinh viên là: 4 x 5 = 20. Total section points là 20/30. 

- Total points: là tổng điểm số của sinh viên. Ví dụ trong trường hợp này tổng số điểm số của sinh viên đạt được là total = 18 + 29 + 31 + 20 = 98. Điểm tối đa của phần bài tập là: 20 + 32 + 40 + 30 = 122. 

- Weighted score: là điểm tính theo trọng số thực tế. Ví dụ trong này weighted score = 98/122 * 45 =  36.1/45

Bạn có thể tham khảo cách tính tổng quát trong công thức sau: 

Screenshot 2019-06-17 at 17.35.59.png

5. Hiển thị kết quả tổng cộng theo môn

- Overall percentage: 86.7 đây là tổng điểm sinh viên đạt được của 3 môn tính theo thang điểm 100. Ví dụ trong này thì overall percentage = 20 + 35 + 

- Your grade will be at least: 3.0 là grade tối thiểu sinh viên có thể đạt được dựa vào điểm số trung bình. Grade max là 4.0. Grade tối thiểu (min grade) dựa vào overall percentage Theo công thức sau: 

- Quy tắc tính min grade: 85% and above: 3.0; 84.99% - 75%: 2.0; 74.99% - 60%: 0.7; under 60%: 0.0. Trong ví dụ này là 86.7, tức là rơi vào khoảng lớn hơn 85%, nên min GPA sẽ là 3.0. 

- Sau phần hiển thị min GPA bạn có thể hiển thị thông báo (nhận xét) tuỳ ý dựa vào GPA của sinh viên. 

Các điều kiện cần đảm bảo

Tổng điểm trọng số: trọng số của 3 phần điểm thi phải có tổng chính xác là 100. Nhỏ hơn hoặc lớn hơn 100 đều không được. Ví dụ trong này là 20 + 35 + 45 = 100. 
Điểm tối đa của phần Assignment là 150, nếu vượt quá thì cũng chỉ tính là 150 điểm. 
Điểm tối đa của phần Attend là 30, nếu vượt quá 30 thì vẫn chỉ tính là 30. 
Phần Weighted score sẽ được làm tròn tới 1 chữ số đằng sau dấu thập phân. 
Phần 2. Tổ chức code

Toàn bộ code sẽ đặt trong file GradeStudent.java 

Chương trình sẽ có hàm main() điều khiển luồng chính của chương trình. Trong hàm main sẽ gọi các hàm con như sau: 

Hàm begin() để hiển thị thông điệp chào mừng.

Hàm midterm() để nhập và tính toán điểm thi giữa kỳ.

Hàm finalterm() để nhập và tính toán điểm thi cuối kỳ. 

Hàm homework() để nhập và tính toán điểm bài tập về nhà.

Hàm report() để tính toán về hiển thị kết quả GPA cũng như thông báo nhận xét tương ứng. 

Phần 3. Tài nguyên

 Không có tài nguyên ban đầu.

Phần 4. Hướng dẫn chi tiết

1. Chương trình sẽ có hàm main() điều khiển luồng chính của chương trình. Trong hàm main sẽ gọi các hàm con như sau: 

2. Hàm begin() để hiển thị thông điệp chào mừng.

3. Hàm midterm() để nhập và tính toán điểm thi giữa kỳ.

4. Hàm final() để nhập và tính toán điểm thi cuối kỳ. 

5. Hàm homework() để nhập và tính toán điểm bài tập về nhà.

6. Hàm report() để tính toán về hiển thị kết quả GPA cũng như thông báo nhận xét tương ứng. 
