import { Component } from "react";

class StudentInfoComponent extends Component {
students = [
    {id:1, name:"Nguyen", age: 18, address: "Ha Noi"},
    {id:2, name:"Tran", age: 29, address: "Da Nang"},
    {id:3, name:"Le", age: 21, address: "Ho Chi Minh"},
]

    render() {
        return(
            <table border={1} cellPadding={5} style={{borderCollapse: "collapse"}}> 
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Address</th>
                    </tr>
                </thead>
                <tbody>
                    {this.students.map((s)=> (
                        <tr key={s.id}>
                            <td>{s.id}</td>
                            <td>{s.name}</td>
                            <td>{s.age}</td>
                            <td>{s.address}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        );
    }
}

export default StudentInfoComponent;