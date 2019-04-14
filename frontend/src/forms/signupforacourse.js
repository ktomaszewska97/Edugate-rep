import React, { Component } from 'react';
import { getCourses } from '../util/APIUtils';

class SignUpForACourse extends Component {
    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            courses: []
        };
    }

    loadCourses() {
      getCourses()
      .then(response => {
        this.setState({
          courses: response,
        });
      }).catch(error => {
        this.setState({
          courses: null
        });  
      });    
      console.log("Sprawdzam!")
    }

    componentDidMount() {
      this.loadCourses();
    }

    render() {
    return (
      <div>
      <p>{this.props.currentUser.name}</p>
      <table class="table table-striped">
        <thead>
          <tr>
            <th>Id</th><th>Nazwa</th><th>Rok</th><th>Zapisz się!</th>
          </tr>
        </thead>
        <tbody>
                {this.state.courses.map(course =>
                  <tr>
                    <td>{course.id}</td>
                    <td>{course.name}</td>
                    <td>{course.about}</td>
                    <td>BUTTON</td>
                  </tr>
                )}
              </tbody>
      </table>
      </div>
      );
  }
}

export default SignUpForACourse;

