import React, { Component } from 'react';
import './Signup.css';
import { Link, Redirect } from 'react-router-dom'
import Alert from 'react-s-alert';
import { newcourserealization } from '../util/APIUtils';

class EditCourseRealizationCard extends Component {
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
                    <h1 className="signup-title">Szczegóły kursu</h1>
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
            noteAboutCourse: '',
            about: ''
        }

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {

        const target = event.target;  

        const inputNote = target.noteAboutCourse;
        const inputNoteValue = target.value;

        const inputAbout = target.about;     
        const inputValueAbout = target.valueabout;  

        this.setState({
            [inputNote] : inputNoteValue,
            [inputAbout] : inputValueAbout
        });     

    }

    handleSubmit(event) {
   
        event.preventDefault();   
        const newCourseRealization = Object.assign({}, this.state);

        console.log(newCourseRealization)
        
        newcourserealization(newCourseRealization)
        .then(response => {
            Alert.success("Dodano realizacje kursu!");
        {/*this.props.history.push("/login");*/}
        }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
        });

    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-item">
                    <input type="text" name="note" 
                        className="form-control" placeholder="Note" 
                        value={this.state.note} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                <textarea type="text" name="about" 
                        className="form-control" placeholder="About"
                        valueabout={this.state.about} onChange={this.handleInputChange} 
                        maxLength="255" required/>
                </div>
                <div className="form-item">
                    <button type="submit" className="btn btn-block btn-primary">Prześlij</button>
                </div>
            </form>                    

        );
    }
}

export default EditCourseRealizationCard;