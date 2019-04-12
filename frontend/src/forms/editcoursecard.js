import React, { Component } from 'react';
import './Signup.css';
import { Link, Redirect } from 'react-router-dom'
import Alert from 'react-s-alert';
import { newdepartament } from '../util/APIUtils';

class EditCourseCard extends Component {
    render() {
        if(this.props.authenticated) {
            return <Redirect
                to={{
                pathname: "/",
                state: { from: this.props.location }
            }}/>;            
        }

        return (
            <div className="signup-container">
                <div className="signup-content">
                    <h1 className="signup-title">Informacje o kursie</h1>
                    <EditDepartamentCardForm {...this.props} />
                </div>
            </div>
        );
    }
}

class EditDepartamentCardForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            semester: '',
            level: ''
        }

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {

        const target = event.target;  

        
        const inputName = target.name; 
        const inputValue = target.value;

        const inputSemester = target.semester;     
        const inputValueSemester = target.valuesemester;  

        const inputLevel = target.level;     
        const inputValueLevel = target.valuelevel;  

        this.setState({
            [inputName] : inputValue,
            [inputSemester] : inputValueSemester,
            [inputLevel] : inputValueLevel,

        });     

    }

    handleSubmit(event) {
   
        event.preventDefault();   
        const newCourseRequest = Object.assign({}, this.state);

        console.log(newCourseRequest)
        
        newdepartament(newCourseRequest)
        .then(response => {
            Alert.success("Dodano kurs!");
            
        this.props.history.push("/editcoursecarddesc");

        }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
        });

    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-item">
                    <input type="text" name="name" 
                        className="form-control" placeholder="Name" 
                        value={this.state.name} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                <input type="number" name="semester" 
                        className="form-control" placeholder="Semester"
                        valuesemester={this.state.semester} onChange={this.handleInputChange} 
                        maxLength="2" required/>
                </div>
                <div className="form-item">
                <input type="number" name="level" 
                        className="form-control" placeholder="Level"
                        valuelevel={this.state.level} onChange={this.handleInputChange} 
                        maxLength="2" required/>
                </div>
                <div className="form-item">
                    <button type="submit" className="btn btn-block btn-primary">Prześlij</button>
                </div>
            </form>                    

        );
    }
}

export default EditCourseCard;