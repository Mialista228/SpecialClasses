**LAB 6**

**1.	Enum: the status of an order**
==========================================================================================================
**Why uppercase()?** To match the uppercase names of enum constants.
**Which exception?** IllegalArgumentException.
**Which version?** firstOrNull version, because it prevents crashes and handles invalid user input gracefully.
**What does Next print?** Next step: CANCELLED
**What is printed?** true, showing enum constants are singletons.
==========================================================================================================
**2.	Enum with a property and a method: a calculator**
==========================================================================================================
**Which line rejects?** b == 0.0 rejects division by zero; fromSymbol rejects abc.
**Where is symbol and code?** Symbol is in the constructor property; addition code is in the ADD constant body. abstract fun apply forces every constant to implement its own calculation.
**Why without instance?** Because fromSymbol is inside a companion object (belongs to the class itself).
==========================================================================================================
**3.	Enum in a when: the cost of delivery**
==========================================================================================================
**Where is the error?** In shippingCost because when is not exhaustive without Delivery.DRONE. main doesn't fail because it uses string lookup (firstOrNull).
**Is it worse?** Yes, because it causes a silent bug instead of a compile-time error when new delivery types are added.
==========================================================================================================
**4.	Sealed class: choose a payment method**
==========================================================================================================
**What is printed without data?** Default object reference (e.g., Payment$Cash@...) instead of a readable string.
**Why not created directly?** Sealed classes are abstract by definition.
**Which are classes/objects?** CreditCard and PayPal are classes (multiple instances); Cash is an object (singleton).
==========================================================================================================
**5.	A new subclass: let the compiler find the places**
==========================================================================================================
**Which line turns red?** The when expression in the process function.
**Is there an error with else?** No, but it hides unhandled states, creating a dangerous silent bug.
**One sentence**: The compiler checks that all direct subclasses of a sealed class are covered in when branches, which it cannot do for a String.
==========================================================================================================
**6.	Sealed UI state: a weather screen**
==========================================================================================================
**Which has no data?** Loading, declared as a data object. Success and Error carry data.
**Which function stops compiling?** render because its when expression is no longer exhaustive.
==========================================================================================================
**7.	Sealed request and response: a login**
==========================================================================================================
**Why do both work?** LoginRequest is a data class (needs is), while LogoutRequest is a singleton object (compared directly by reference).
**What to change?** Change subclasses to inherit with parentheses (: ApiRequest()).
**Which function stops compiling?** handleRequest.
==========================================================================================================
**8.	Constructors of a sealed class: form errors**
==========================================================================================================
**Error in main?** Cannot instantiate sealed class directly.
**Which modifiers compile?** Only protected and private (default is protected). Public/internal are not allowed.
==========================================================================================================
**9.	An enum inside a sealed class: incident log**
==========================================================================================================
**Order?** Descending order of severity (sortedByDescending) because enums implement Comparable.
**What do results show?** true (same instance from list filter), true (same severity).
**Which when stops?** The describe function (when) stops compiling because BLOCKER is missing. Sorting/counting work without changes.
==========================================================================================================
**10.	 An enum in a sealed family: media player commands**
==========================================================================================================
**Why error?** An enum class cannot extend another class in Kotlin.
**What does compiler say?** The when expression is not exhaustive.
==========================================================================================================
**11.	 Several sealed interfaces: devices at home**
==========================================================================================================
**Which implement two?** Phone and Headphones. Toaster is allowed because the list holds type Any.
**Error with classes?** Kotlin does not support multiple class inheritance.
**Why does it compile?** chargingNote takes Chargeable, and SmartLamp only implements Wireless.
==========================================================================================================
**12.	 Where may subclasses live? An error reporter**
==========================================================================================================
**Does DiskFull compile?** Yes, because it is in the same package and module.
**Error in other package?** Direct subclasses of a sealed type must be in the same package and module.
**CustomError?** It compiles because CustomError is an open class, not sealed. report handles it via is CustomError.
**Local/anonymous errors?** Local classes and anonymous objects cannot be direct subclasses of a sealed type.
Who may extend? AppError and IoError: only same package and module; CustomError: anyone who sees it.
