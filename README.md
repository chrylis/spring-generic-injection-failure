spring-generic-injection-failure
================================

This is a minimal failing example for [an injection problem I was facing](http://stackoverflow.com/q/22856547/1189885).
When a Controller class has a generic type parameter applied to it, Spring cannot solve for an acceptable type argument
and match an implementing generic service bean for injection. Manually subclassing the controller with a literal type
argument allows Spring to autowire the context, but it would be helpful if the container could solve this issue on its own.

This example uses Spring Boot to launch a container, and shows a very simple job-status tracker. The `JobStatus` type
is an interface because implementations might use a number of persistence strategies for saving this information (in my
case, MongoDB documents for now with a likely transition to a query-backed Activiti repository), and using a concrete
class for this case is not suitable. The `JobStatusService` needs to be able to accept its own `JobStatus` objects back
for update operations and thus is parameterized on `JS extends JobStatus`. The `Controller` class doesn't care what the
runtime type of `JS` is as long as it knows it can hand the result of a `find` query back to the service for updates.

As-is, this example runs correctly. To switch off the manual controller subclass and see the desired (but non-working)
configuration, change the runtime Spring profile to `generic` instead of `nongeneric` to attempt to wire the base
controller class directly. 