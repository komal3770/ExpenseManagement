<div class="container">
	<div class="row">
		<div class="span4">
			<h4>
				<b>Sign In</b>
			</h4>
			<div id="errormessage"></div>
			<form action="" method="post" role="form" class="clsForm">
				<div class="row">
					<div class="span4 form-group field">
						<input type="text" name="username" id="username"
							placeholder="Username" data-rule="minlen:4"
							data-msg="Please enter at least 4 chars" />
						<div class="validation"></div>
					</div>
					<br>
					<div class="span4 form-group">
						<input type="password" name="password" id="password"
							placeholder="Password" data-rule="minlen:4"
							data-msg="Please enter at least 4 chars" />
						<div class="validation"></div>
					</div>
					<br>
					<div class="span4 form-group">
						<div class="validation"></div>
						<div class="text">
							<button class="btn btn-theme btn-medium margintop10"
								type="submit">Login</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>