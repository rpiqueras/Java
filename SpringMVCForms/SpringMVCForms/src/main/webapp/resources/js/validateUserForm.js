/**
 * 
 */
$.validator.addMethod("loginFormat", function(value, element){
	return this.optional(element) || /^[A-Za-z0-9]+$/.test(value);
}, "Must contain only chars and numbers");

var validator = $("#createUserForm").validate({
	rules: {
		login: {
			required: true,
			minlength: 2,
			maxlength: 17,
			loginFormat: true
		},
		password: {
			required: true,
			minlength: 2,
			maxlength: 17,
		},
		description: {
			maxlength: 260,
		}
	},
	messages: {
		login: {
			required: "Enter a login",
			minlength: $.validator.format("Enter at least {0} characters"),
			maxlength: $.validator.format("Enter less than {0} characters"),
		},
		password: {
			required: "Provide a password",
			minlength: $.validator.format("Enter at least {0} characters"),
			maxlength: $.validator.format("Enter less than {0} characters"),
		},
		description: {
			maxlength: $.validator.format("Enter less than {0} characters"),
		}
	},
	errorPlacement: function(error, element){
		error.insertAfter(element);
	},
	submitHandler: function(form){
		form.submit();
	}
});