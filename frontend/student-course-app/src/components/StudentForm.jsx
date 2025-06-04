import axios from "axios";
import React, {useEffect,useState} from "react"; 


function StudentForm(){
    const [courses, setCourses] = useState([]);
    const [student, setStudent] = useState({
        studentId: "",
        name: "",
        courses: []
    });
    const [selectedCourse, setSelectedCourse] = useState(null);

    useEffect(() => {
        axios.get("http://localhost:8080/api/courses")
        .then(response => {
            console.log("Courses fetched:",response.data);
            setCourses(response.data)
        })
            
        .catch(err => console.error(err));
    }, []);

    const handleSelect = (e) =>{
        const courseId = e.target.value;
        const selected = courses.find(c => c.courseId === courseId);
        setSelectedCourse(selected);
        setStudent({ ...student, courses: [{ courseId: e.target.value}]});
    };

        
 
    const handleChange = (e) =>
        setStudent({ ...student, [e.target.name]: e.target.value});

    const handleSubmit = (e) =>{
        e.preventDefault();
        axios.post("http://localhost:8080/api/students", student)
            .then(() => alert("Student registered"))
            .catch(err => console.error(err));
    };

    return(
        <form onSubmit={handleSubmit}>
            <input name="studentId" placeholder="Student ID" onChange={handleChange}/>
            <input name="name" placeholder="Student Name" onChange={handleChange}/>
            <select onChange={handleSelect} defaultValue="">
                <option value ="" disabled>Select a Course</option>
                    {courses.map(c => (
                        <option key={c.courseId} value={c.courseId}>
                            {c.courseName}
                        </option>
                    ))}
            </select>
            <button type="submit">Register</button>

            {
                selectedCourse && (
                    <div>
                        <p><strong>Course Name:</strong>{selectedCourse.courseName}</p>
                        <p><strong>Division:</strong>{selectedCourse.division}</p>

                    </div>
                )
            }

        </form>
    )
}

export default StudentForm;