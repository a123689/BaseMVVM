# BaseMVVM
1. Ưu điểm MVVM
Thành phần giao diện tách riêng với xử lý logic
Thành phần xử lý logic được tách riêng với nơi lấy dữ liệu
Vòng đời của app được duy trì
Dễ test, bảo trì
2. Thành phần MVVM
alt text

Repositories
Repository xử lý việc gửi nhận dữ liệu. Tạo repository là 1 cách làm tốt để phân biệt rõ ràng giữa cách ứng dụng nhận dữ liệu và cách nó sử dụng/ hiển thị dữ liệu

Repository biết sẽ phải lấy dữ liệu từ ở đâu (ví dụ query api, query database)

Để ý rằng mỗi thành phần chỉ phụ thuộc vào 1 thành phần bên dưới nó. Đây là 1 phần rất quan trọng trong tối ưu hóa cấu trúc code. Repository đóng vai trò là 1 cổng cho việc trao đổi dữ liệu

View Models
ViewModel à nơi tiếp nhận dữ liệu (từ repository) và xử lý logic liên quan. ViewModel sẽ tồn tại trong bộ nhớ đến khi vòng đời mà nó gắn vào trước đó bị hủy bỏ hoàn toàn. Trong trường hợp activity là khi activity bị finish, còn trong trường hợp fragment là khi nó bị detach.

View
Là activity/fragment - nơi cập nhật giao diện. Nó sẽ không biết dữ liệu đến từ đâu, được xử lý logic ra sao mà chỉ quan tâm sẽ cập nhật giao diện như thế nào với dữ liệu được trả về từ viewmodel.

