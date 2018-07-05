<%-- 
    Document   : shcSubjectNumber
    Created on : Oct 30, 2016, 10:09:08 PM
    Author     : Rasel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/main.css">

    </head>
    <body style="background-color: #3e8f3e">
        <div style="text-align: center">
            <h1>School Management System</h1>
            <h4>Academic Transcript</h4> 
        </div> 
        <div class="container" style="background-color: #b8b56e">
            <fieldset style="margin-top: 30px">
                <form action="SSCSubjectNumber" method="post" onsubmit="return validateForm()" >
                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">Roll no.</label>
                        <div class="col-sm-3">
                            <input type="text" name="rollNo" class="form-control" id="roll_no" maxlength="11" onkeypress="return isNumberKey(event)"/>
                        </div>
                        <label for="example-text-input" class="col-sm-3 col-form-label">Registration no.</label>
                        <div class="col-sm-3">
                            <input type="text" name="regNo" class="form-control" id="reg_no" onkeypress="return isNameValidtion(event)"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">Name of Student</label>
                        <div class="col-sm-9">
                            <input type="text" id="student_n" name="studentN" class="form-control" onkeypress="return isNameValidtion(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">Fathers Name</label>
                        <div class="col-sm-9">
                            <input type="text" id="fa_name" name="faName" class="form-control" onkeypress="return isNameValidtion(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">Mothers Name</label>
                        <div class="col-sm-9">
                            <input type="text" id="mo_name" name="moName" class="form-control" onkeypress="return isNameValidtion(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">Name of Institution</label>
                        <div class="col-sm-9">
                            <input type="text" id="n_istitution" name="nIstitution" class="form-control" onkeypress="return isNameValidtion(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">Group</label>
                        <div class="col-sm-3">
                            <input type="text" id="group_n" name="group" class="form-control" value="Science"/>
                        </div>
                        <label for="example-text-input" class="col-sm-3 col-form-label">Date of Birth</label>
                        <div class="col-sm-3">
                            <input type="text" id="d_o_b" name="dob" class="form-control" placeholder="dd-MM-yyy" />
                        </div>
                    </div>

                    <br><br>

                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">Bangla 1st Part</label>
                        <div class="col-sm-3">
                            <input type="text" id="bang_1" name="bang1" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                        <label for="example-text-input" class="col-sm-3 col-form-label">Bangla 2nd Part</label>
                        <div class="col-sm-3">
                            <input type="text" id="bang_2" name="bang2" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">English 1st Part</label>
                        <div class="col-sm-3">
                            <input type="text" id="eng_1" name="eng1" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                        <label for="example-text-input" class="col-sm-3 col-form-label">English 2nd Part</label>
                        <div class="col-sm-3">
                            <input type="text" id="eng_2" name="eng2" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">General Mathematics</label>
                        <div class="col-sm-3">
                            <input type="text" id="g_math" name="gMath" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                        <label for="example-text-input" class="col-sm-3 col-form-label">Religious Education</label>
                        <div class="col-sm-3">
                            <input type="text" id="religious_e" name="religiousE" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">Social Science</label>
                        <div class="col-sm-3">
                            <input type="text" id="social_s" name="socialS" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                        <label for="example-text-input" class="col-sm-3 col-form-label">Physics</label>
                        <div class="col-sm-3">
                            <input type="text" id="physics_s" name="physicsS" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">Chemistry</label>
                        <div class="col-sm-3">
                            <input type="text" id="chemistry_s" name="chemistryS" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                        <label for="example-text-input" class="col-sm-3 col-form-label">Higher Mathematics</label>
                        <div class="col-sm-3">
                            <input type="text" id="h_math" name="hMath" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="example-text-input" class="col-sm-3 col-form-label">Biology</label>
                        <div class="col-sm-3">
                            <input type="text" id="biology_S" name="biologyS" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                        <label for="example-text-input" class="col-sm-3 col-form-label">Computer Studies</label>
                        <div class="col-sm-3">
                            <input type="text" id="computer_s" name="computerS" class="form-control" maxlength="3" onkeypress="return isNumberKey(event)"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-6">
                            <button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
                        </div>
                        <div class="col-sm-6">
                            <button type="reset" class="btn btn-primary btn-lg btn-block">Reset</button>
                        </div>
                        <div class="col-sm-6">
                            <button type="submit" class="btn btn-primary btn-lg btn-block">Update</button>
                        </div>
                        <div class="col-sm-6">
                            <button type="reset" class="btn btn-primary btn-lg btn-block">Delete</button>
                        </div>
                    </div>
                    </div>

                    <br/><br/>
                    <br/><br/>
                </form>
            </fieldset>

            <script src="js/jquery-3.1.1.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/main.js"></script>
    </body>
</html>
