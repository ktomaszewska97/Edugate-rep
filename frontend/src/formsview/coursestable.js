import React, { Component } from 'react';
import { getCourses, getCourseById } from '../util/APIUtils';

class CoursesTable extends Component {
    constructor(props) {
        super(props);
        
        this.state = {
            courses: [],
            loading: false
        };
    }

    loadCourses() {
      this.setState({
        loading: true
      });

      getCourses()
      .then(response => {
        this.setState({
          courses: response,
          loading: false
        });
      }).catch(error => {
        this.setState({
          courses: null,
          loading: false
        });  
      });    
    }

    componentDidMount() {
      this.loadCourses();
    }

    render() {
    return (
      <div>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Id</th><th>Nazwa</th><th>Semestr</th>
          </tr>
        </thead>
        <tbody>
                {this.state.courses.map(course =>
                  <tr>
                    <td>{course.idCourse}</td>
                    <td>{course.name}</td>
                    <td>{course.semester}</td>
                  </tr>
                )}
              </tbody>
      </table>
      </div>
      );
  }
}

export default CoursesTable;

