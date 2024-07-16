
Function FillRoom_Cont_457(r.Rooms)
	Local d.Doors, it.Items
	Local i
	
			;d = CreateDoor(r\zone, r\x,r\y,r\z,0,r,False,2,False,"ABCD")
			;d\AutoClose = False
			;d\Locked = True
	d = CreateDoor(r\zone, r\x,r\y-1024.0*RoomScale,r\z,0,r,False,2,False,"ABCD")
	d\AutoClose = False
	d\Locked = True
	d = CreateDoor(r\zone, r\x-1060.0*RoomScale,r\y-1024.0*RoomScale,r\z+1792.0*RoomScale,90,r,True,False)
	d\AutoClose = False
	d\Locked = True
	d = CreateDoor(r\zone, r\x+8480.0*RoomScale,r\y-1024.0*RoomScale,r\z+1536.0*RoomScale,90,r,False,False)
	FreeEntity(d\buttons[0]) : d\buttons[0] = 0
	FreeEntity(d\buttons[1]) : d\buttons[1] = 0
	d\AutoClose = False
	d\Locked = True
	d\open = True
	d = CreateDoor(r\zone, r\x+8960.0*RoomScale,r\y-1024.0*RoomScale,r\z+1536.0*RoomScale,90,r,False,False)
	FreeEntity(d\buttons[0]) : d\buttons[0] = 0
	FreeEntity(d\buttons[1]) : d\buttons[1] = 0
	d\AutoClose = False
	d\Locked = True
	d\open = True
	d = CreateDoor(r\zone, r\x+8064.0*RoomScale,r\y-1024.0*RoomScale,r\z+1248.0*RoomScale,0,r,False,False,3)
	
	r\RoomDoors[0] = CreateDoor(r\zone, r\x-256.0*RoomScale,r\y,r\z-656.0*RoomScale,90,r,False,False)
	r\RoomDoors[0]\AutoClose = False
	r\RoomDoors[0]\open = True
	r\RoomDoors[1] = CreateDoor(r\zone, r\x+256.0*RoomScale,r\y,r\z+656.0*RoomScale,90,r,False,False)
	r\RoomDoors[1]\AutoClose = False
	r\RoomDoors[1]\open = True
	r\RoomDoors[2] = CreateDoor(r\zone, r\x-256.0*RoomScale,r\y-1024.0*RoomScale,r\z-656.0*RoomScale,90,r,False,False)
	r\RoomDoors[2]\AutoClose = False
			;r\RoomDoors[2]\open = True
	r\RoomDoors[3] = CreateDoor(r\zone, r\x+256.0*RoomScale,r\y-1024.0*RoomScale,r\z+656.0*RoomScale,90,r,False,False)
	r\RoomDoors[3]\AutoClose = False
			;r\RoomDoors[3]\open = True
	
	r\RoomDoors[4] = CreateDoor(r\zone, r\x+9216.0*RoomScale,r\y-1024.0*RoomScale,r\z+1248.0*RoomScale,0,r,False,False)
	FreeEntity(r\RoomDoors[4]\buttons[0]) : r\RoomDoors[4]\buttons[0] = 0
	FreeEntity(r\RoomDoors[4]\buttons[1]) : r\RoomDoors[4]\buttons[1] = 0
	r\RoomDoors[4]\AutoClose = False
	r\RoomDoors[4]\open = True
	
	r\Objects[0] = CreatePivot()
	PositionEntity r\Objects[0],r\x,r\y-784.0*RoomScale,r\z+3072.0*RoomScale
	EntityParent r\Objects[0],r\obj
	r\Objects[1] = CreatePivot()
	PositionEntity r\Objects[1],r\x+1024.0*RoomScale,r\y-784.0*RoomScale,r\z-192.0*RoomScale
	EntityParent r\Objects[1],r\obj
	r\Objects[2] = CreatePivot()
	PositionEntity r\Objects[2],r\x+5952.0*RoomScale,r\y-784.0*RoomScale,r\z-256.0*RoomScale
	EntityParent r\Objects[2],r\obj
	r\Objects[3] = CreatePivot()
	PositionEntity r\Objects[3],r\x+4768.0*RoomScale,r\y-784.0*RoomScale,r\z+3072.0*RoomScale
	EntityParent r\Objects[3],r\obj
	
	r\Objects[4] = CreatePivot()
	PositionEntity r\Objects[4],r\x-560.0*RoomScale,r\y+240.0*RoomScale,r\z-656.0*RoomScale
	EntityParent r\Objects[4],r\obj
	r\Objects[5] = CreatePivot()
	PositionEntity r\Objects[5],r\x+560.0*RoomScale,r\y+240.0*RoomScale,r\z+656.0*RoomScale
	EntityParent r\Objects[5],r\obj
	r\Objects[6] = CreatePivot()
	PositionEntity r\Objects[6],r\x-560.0*RoomScale,r\y-784.0*RoomScale,r\z-656.0*RoomScale
	EntityParent r\Objects[6],r\obj
	r\Objects[7] = CreatePivot()
	PositionEntity r\Objects[7],r\x+560.0*RoomScale,r\y-784.0*RoomScale,r\z+656.0*RoomScale
	EntityParent r\Objects[7],r\obj
	
	it = CreateItem("Document SCP-457 Page 1/2", "paper",r\x + 1728.0*RoomScale,r\y - 828.0*RoomScale,r\z - 128.0*RoomScale)
	EntityParent(it\collider,r\obj)
	it = CreateItem("Document SCP-457 Page 2/2", "paper",r\x + 8368.0*RoomScale,r\y - 892.0*RoomScale,r\z + 464.0*RoomScale)
	EntityParent(it\collider,r\obj)
	
	r\Objects[8] = LoadMesh_Strict("GFX\map\heavydoor1.x")
	ScaleEntity r\Objects[8],RoomScale,RoomScale,RoomScale
	PositionEntity r\Objects[8],r\x,r\y,r\z
	EntityParent r\Objects[8],r\objEnd Function
Function UpdateEvent_Cont_457(e.Events)		;e\EventState = The "Main" State
				;1/2/3/4: 	the Player is inside the tunnels and it's determining which TargetPoint SCP-457 should use to walk around
				;-1/0: The positioning of the door
	
	If PlayerRoom = e\room
		If EntityY(Collider) < -600.0*RoomScale
			If e\room\NPC[0]=Null
				DrawLoading(0,True)
				e\room\NPC[0]=CreateNPC(NPCtype457, EntityX(e\room\Objects[0],True), EntityY(e\room\Objects[0],True)+0.1, EntityZ(e\room\Objects[0],True))
				DrawLoading(40,True)
				DrawLoading(100,True)
				e\EventState = Rand(1,4)
			Else
				ShouldPlay = 17
				If e\room\NPC[0]\State = 2
					e\room\NPC[0]\State = 0
					PositionEntity e\room\NPC[0]\Collider,EntityX(e\room\Objects[0],True), EntityY(e\room\Objects[0],True)+0.1, EntityZ(e\room\Objects[0],True)
				EndIf
				If e\EventState > 0.0
					e\room\NPC[0]\TargetEnt% = e\room\Objects[(Int(e\EventState-1))]
				EndIf
				If e\room\NPC[0]\PathStatus <> 1
					e\EventState = Rand(1,4)
				EndIf
			EndIf
			
			For r.Rooms = Each Rooms
				HideEntity r\obj
			Next					
			ShowEntity e\room\obj
			CameraRange(Camera, 0.01, Min(CameraFogFar*LightVolume*1.5,9))
			
			If EntityY(Collider)<-2300.0*RoomScale And KillTimer=>0 Then
				DeathMSG="MTF Unit [REDACTED] found dead inside an elevator shaft located inside the Storage Area 457"
				PlaySound_Strict LoadTempSound("SFX\Room\PocketDimension\Impact.ogg")
				KillTimer=-1.0
			EndIf
		Else
			If e\room\NPC[0] <> Null
				e\room\NPC[0]\State = 2
			EndIf
			If e\EventState > 0.0
				e\EventState = 0.0
			EndIf
			
			If PlayerRoom = e\room
				e\EventState = Rand(-1,0)
				If e\EventState = 0.0
					MoveEntity e\room\Objects[8],2.5*FPSFactor,0,0
				Else
					MoveEntity e\room\Objects[8],-2.5*FPSFactor,0,0
				EndIf
				
				PositionEntity e\room\Objects[8],Max(Min(EntityX(e\room\Objects[8]),25.0),0.0),EntityY(e\room\Objects[8]),EntityZ(e\room\Objects[8])
				
				e\SoundCHN = LoopSound2(NTF_BrokenDoorSFX,e\SoundCHN,Camera,e\room\Objects[8],5)
			EndIf
		EndIf
		
		e\EventState2 = UpdateElevators(e\EventState2,e\room\RoomDoors[0],e\room\RoomDoors[2],e\room\Objects[4],e\room\Objects[6],e)
		e\EventState3 = UpdateElevators(e\EventState3,e\room\RoomDoors[1],e\room\RoomDoors[3],e\room\Objects[5],e\room\Objects[7],e)
	EndIf
End Function
;~IDEal Editor Parameters:
;~C#Blitz3D