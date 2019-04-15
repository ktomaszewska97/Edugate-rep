import React, { Component } from 'react';
import { getCourses, signupforcourse } from '../util/APIUtils';
import Alert from 'react-s-alert';

class SignUpForACourse extends Component {
    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            courses: [],
            idCourse:'',
            idUser:''
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

    
    handleInputChange(event) {

      const target = event.target;  

      
      const inputIdCourse = target.idCourse; 
      const inputValue = target.value;

      const inputIdUser = target.idUser;     
      const inputValueIdUser = target.valueuser;  

      this.setState({
          [inputIdCourse] : inputValue,
          [inputIdUser] : inputValueIdUser
      });     

  }

  handleSubmit(event) {
 
      event.preventDefault();   
      const newSignUpRequest = Object.assign({}, this.state);
      
      signupforcourse(newSignUpRequest)
      .then(response => {
          Alert.success("!");
      {/*this.props.history.push("/login");*/}
      }).catch(error => {
          Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
      });

  }

    render() {
    return (
      <div>
      <table class="table table-striped">
        <thead>
          <tr>
            <th>Id</th><th>Nazwa</th><th>Rok</th><th>Zapisz się!</th>
          </tr>
        </thead>
        <tbody>
                {this.state.courses.map(course =>
                  <tr>
                    <td>{course.idCourse}</td>
                    <td>{course.name}</td>
                    <td>{course.about}</td>
                    <td>
                    <form onSubmit={this.handleSubmit}>
                    <input type="hidden" name="idcourse" 
                        className="form-control"
                        value={this.state.idcourse} onChange={this.handleInputChange} required/>
                     <input type="hidden" name="iduser" 
                        className="form-control"
                        valueuser={this.props.currentUser.id} onChange={this.handleInputChange} required/>
                    </form>
                    <button type="submit" className="btn btn-block btn-primary">Zapisz</button>
                    </td>
                  </tr>
                )}
              </tbody>
      </table>
      </div>
      );
  }
}

export default SignUpForACourse;

