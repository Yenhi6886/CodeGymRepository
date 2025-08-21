import { useState } from "react";

function App() {
const [isOpen, setIsOpen] = useState(false);

  return(
    <div>
      <h1>Conditional Rendering</h1>
      {isOpen && (
        <p>Nhưng Chu Du Kỳ học thức, gia thế đều không bằng hắn ta, lại nhờ vào dung mạo tuấn tú và tiền bạc mà nổi bật sau kỳ thi Đình.
Kết giao với nhi tử của Lại bộ Thị lang, lại còn được tiểu thư nhà Tống Thượng thư để ý, người này rõ ràng tham lam nhưng lại còn giả vờ làm giá, ở Hàn Lâm Viện lấn át Khổng Thanh Tư.
Khổng Thanh Tư coi thường hắn, hắn ta xuất thân tốt, tự cho mình thanh cao, có chút kiêu ngạo, nhưng lại là người nói được làm được, cũng thật sự không muốn cùng hạng với những người như Dương An.
Có người không thích hắn, tự nhiên cũng có người khâm phục hắn. Chu Du Kỳ đã sớm biết Khổng Thanh Tư không thích hắn, nên cũng không bám víu hắn ta, nhưng không ngờ, hôm nay Khổng Thanh Tư lại xảy ra xung đột với hắn trước mặt mọi người.

Dương An lại đến tìm hắn, hắn đành phải bỏ dở công việc để đi gặp Dương An, khi trở về, liền nghe thấy Khổng Thanh Tư lạnh lùng nói: "Kẻ xu nịnh, thật không thể chịu nổi."

Lúc đó, Hàn Lâm Viện im lặng, mọi người xung quanh nhìn nhau. Chu Du Kỳ không muốn gây chuyện, nhưng cũng không phải là người dễ bắt nạt, bị người ta tát vào mặt, nếu không đáp trả, sau này ở quan trường sẽ khó làm người.

Hắn chỉ có thể nói: "Kết giao bằng hữu là xu nịnh, người tự cao tự đại như vậy đương nhiên không cần bạn bè."

Ai cũng nhìn ra được mùi thuốc súng giữa hai người này, người muốn hòa giải cũng không muốn xen vào. Chu Du Kỳ thoạt nhìn không có quyền không có thế, nhưng ai bảo hắn được tiểu thư nhà Tống gia để ý, nói về thế lực trong triều, một trăm Khổng gia cũng không bằng Tống gia, ai biết Chu Du Kỳ có lật kèo hay không?

Xu nịnh quả thật khiến người ta coi thường, nhưng người không biết thay đổi dường như càng khó sống sót ở quan trường. Khổng Thanh Tư có chút tức giận, nhưng hắn ta còn chưa kịp nổi giận, liền khẽ nhếch môi, cảm thấy hắn giả tạo, có một khoảnh khắc hắn ta thậm chí không muốn nói chuyện với hắn. Một lúc lâu sau, Khổng Thanh Tư mới nói: "Ta nghe nói thê tử mà ngươi cưới ở Cù Châu là thương nhân, cầm tiền của hồi môn của thê tử cho người khác ăn chơi hưởng lạc, lại còn dây dưa không rõ với tiểu thư nhà họ Tống, Chu Ứng Phụng ngươi định làm gì?" Hắn ta chỉ nói một câu đơn giản, sau đó cười khẩy một tiếng, cũng không nghe Chu Du Kỳ giải thích, hắn ta liền xoay người rời đi.
</p>)}
{!isOpen ? (
  <button onClick={()=> setIsOpen(true)}>Review</button>
) : (
  <button onClick={() => setIsOpen(false)}>Close</button>
)} 
   </div>
  )
}
export default App;