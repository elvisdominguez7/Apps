import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

class Show extends Component {

  constructor(props) {
    super(props);
    this.state = {
      user: {}
    };
  }

  componentDidMount() {
    axios.get('/users/'+this.props.match.params.id)
      .then(res => {
        this.setState({ user: res.data });
        console.log(this.state.user);
      });
  }

  delete(id){
    console.log(id);
    axios.delete('/users/'+id)
      .then((result) => {
        this.props.history.push("/")
      });
  }

  render() {
    return (
      <div class="container">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">
              user Details
            </h3>
          </div>
          <div class="panel-body">
            <h4><Link to="/"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> users List</Link></h4>
            <dl>
              <dt>First Name:</dt>
              <dd>{this.state.user.firstname}</dd>
              <dt>Last Name:</dt>
              <dd>{this.state.user.lastname}</dd>
              <dt>Address:</dt>
              <dd>{this.state.user.address}</dd>
              <dt>City:</dt>
              <dd>{this.state.user.city}</dd>
              <dt>Phone Number:</dt>
              <dd>{this.state.user.phone}</dd>
              <dt>Email Address:</dt>
              <dd>{this.state.user.email}</dd>
            </dl>
            <Link to={`/edit/${this.state.user.id}`} class="btn btn-success">Edit</Link>&nbsp;
            <button onClick={this.delete.bind(this, this.state.user.id)} class="btn btn-danger">Delete</button>
          </div>
        </div>
      </div>
    );
  }
}

export default Show;