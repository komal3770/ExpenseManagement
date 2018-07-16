<form action="" method="post" role="form" class="loginForm">
	<div class="row">
		<div class="span4 form-group field">
			<input type="text" name="username" id="username"
				placeholder="Username" data-rule="minlen:4"
				data-msg="Please enter at least 4 chars" />
			<div class="validation"></div>
		</div>

		<div class="span8 form-group">
			<input type="password" name="password" id="password"
				placeholder="Password" data-rule="minlen:4"
				data-msg="Please enter at least 4 chars" />
			<div class="validation"></div>
		</div>
		<div class="span8 form-group">
			<div class="validation"></div>
			<div class="text-center">
				<button class="btn btn-theme btn-medium margintop10" type="submit">Login</button>
			</div>
		</div>
	</div>
</form>