<div class="row">
	<div class="span4">
		<!-- <h4>Registration</h4> -->
		<fieldset>
		<div id="errormessage"></div>
		<form action="" method="post" role="form" class="clsForm">
			<div class="row">
				<div class="span4 form-group">
					<input type="email" name="email" id="email"
						placeholder="Your Email" data-rule="email"
						data-msg="Please enter a valid email" />
					<div class="validation"></div>
				</div>
				<br>
				<div class="span4 form-group">
					<input type="text" name="mobileNo" id="mobileNo"
						placeholder="Mobile No" data-rule="minlen:10"
						data-msg="Please enter at least 10 digits number" />
					<div class="validation"></div>
				</div>
				<br>
				<div class="span4 form-group">
					<input type="password" name="password" id="password"
						placeholder="Password" data-rule="minlen:4"
						data-msg="Please enter at least 4 char" />
					<div class="validation"></div>
				</div>
				<div class="span4 form-group">
					<div class="validation"></div>
					<div>
						<button class="btn btn-theme btn-medium margintop10" type="submit">Signup</button>
					</div>
				</div>
			</div>
		</form>
		</fieldset>
	</div>
</div>